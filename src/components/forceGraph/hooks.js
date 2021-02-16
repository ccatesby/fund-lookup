import { useState } from 'react';
import { filter, pipe, forEach, curry, compose } from 'ramda';

const unquieIds = (arrayData) => new Set(arrayData.map((d) => d.id));

const getTargetNode = (target) =>
  typeof target === 'object' ? target.id : target;

const curryCountLinks = curry(
  (links, node) =>
    filter(
      (link) =>
        getTargetNode(link.source) === node.id ||
        getTargetNode(link.target) === node.id,
    )(links).length,
);

const curryHasDuplicateLink = curry(
  (links, link) =>
    links.filter(
      (l) =>
        ((getTargetNode(l.target) === getTargetNode(link.target) &&
          getTargetNode(l.source) === getTargetNode(link.source)) ||
          (getTargetNode(l.target) === getTargetNode(link.source) &&
            getTargetNode(l.source) === getTargetNode(link.target))) &&
        link.type === l.type,
    ).length === 0,
);

const filterById = curry((unquieIds, updatedNodeData) =>
  filter(({ id }) => !unquieIds.has(id))(updatedNodeData),
);

const mergeArrays = curry((array1, array2) => [...array1, ...array2]);

const useGraphData = (refetch) => {
  const [graphData, setGraphData] = useState({
    nodes: [],
    links: [],
  });

  const filterExistingNodes = compose(filterById, unquieIds);
  const filterExistingLinks = compose(filter, curryHasDuplicateLink);

  const appendLinkCount = curry((links, nodes) => {
    const countLinksForNode = curryCountLinks(links);
    return forEach((n) => (n.linksCount = countLinksForNode(n)))(nodes);
  });

  const pipeUpdatedLinks = pipe(
    filterExistingLinks(graphData.links),
    mergeArrays(graphData.links),
  );

  const pipeUpdatedNodes = (updatedLinks) =>
    pipe(
      filterExistingNodes(graphData.nodes),
      mergeArrays(graphData.nodes),
      appendLinkCount(updatedLinks),
    );

  const fetchGraphData = async (nodeId) => {
    var { data } = await refetch({
      variables: { nodeId: nodeId },
    });
    const { nodes, links } = data.graphById;
    const updatedLinks = pipeUpdatedLinks(links, graphData.links);
    const updatedNodes = pipeUpdatedNodes(updatedLinks)(nodes);

    setGraphData({
      nodes: updatedNodes,
      links: updatedLinks,
    });
  };
  return {
    fetchGraphData,
    graphData,
  };
};

export { useGraphData };
