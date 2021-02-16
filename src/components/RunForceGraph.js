import React, { useEffect } from 'react';
import { ForceGraph3D } from 'react-force-graph';
import { useGraphData } from './forceGraphHooks';

export function RunForceGraph({ refetch }) {
  const { fetchGraphData, graphData } = useGraphData(refetch);

  useEffect(() => {
    (async function () {
      await fetchGraphData(1);
    })();
  }, []);

  const getColor = (value) => {
    value /= 5;
    const hue = ((1 - value) * 120).toString(10);
    return ['hsl(', hue, ',100%,50%)'].join('');
  };

  const handleClick = async (node) => {
    await fetchGraphData(node.id);
  };

  const nodeVal = (node) => node.linksCount;

  const getNodeColor = (node) =>
    node.type === 'Fund' ? 'red' : getColor(node.linksCount);

  return (
    <>
      <div>nodes: {graphData.nodes.length}</div>
      <div>links: {graphData.nodes.length}</div>
      <ForceGraph3D
        graphData={graphData}
        linkDirectionalParticles={2}
        onNodeClick={handleClick}
        nodeOpacity={1}
        nodeId="id"
        nodeVal={nodeVal}
        nodeLabel="linksCount"
        backgroundColor="#101020"
        nodeColor={getNodeColor}
      />
    </>
  );
}
