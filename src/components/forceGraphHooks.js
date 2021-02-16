import { useState } from 'react';
import { filter, pipe, forEach, curry } from 'ramda';

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

const curryHasLink = curry(
  (links, link) =>
    filter(
      (l) =>
        ((getTargetNode(l.target) === getTargetNode(link.target) &&
          getTargetNode(l.source) === getTargetNode(link.source)) ||
          (getTargetNode(l.target) === getTargetNode(link.source) &&
            getTargetNode(l.source) === getTargetNode(link.target))) &&
        link.type === l.type,
    )(links).length === 0,
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

  const filterExistingNodes = filterById(unquieIds(graphData.nodes));
  const mergeIntoExistingNodes = mergeArrays(graphData.nodes);
  const filterExisting = curryHasLink(graphData.nodes);
  const mergeLinks = mergeArrays(graphData.links);

  const filterExistingLinks = (updatedLinks) =>
    filter(filterExisting)(updatedLinks);

  const pipeUpdatedLinks = pipe(filterExistingLinks, mergeLinks);

  const appendLinkCount = curry((links, nodes) => {
    const countLinksForNode = curryCountLinks(links);
    return forEach((n) => (n.linksCount = countLinksForNode(n)))(nodes);
  });

  const pipeUpdatedNodes = (updatedLinks) =>
    pipe(
      filterExistingNodes,
      mergeIntoExistingNodes,
      appendLinkCount(updatedLinks),
    );

  const fetchGraphData = async (nodeId) => {
    var { data } = await refetch({
      variables: { nodeId: nodeId },
    });
    const { nodes, links } = data.graphById;
    const updatedLinks = pipeUpdatedLinks(links);
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
