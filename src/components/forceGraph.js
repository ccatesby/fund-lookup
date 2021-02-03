import React from "react";
import { runForceGraph } from "./forceGraphGenerator";
import styled from 'styled-components';

const Container = styled.div`
  height: 100%;
  width: 100%;
`;

export function ForceGraph({ linksData, nodesData }) {
  const containerRef = React.useRef(null);

  React.useEffect(() => {
    let destroyFn;

    if (containerRef.current) {
      const { destroy } = runForceGraph(containerRef.current, linksData, nodesData);
      destroyFn = destroy;
    }

    return destroyFn;
  }, []);

  return <Container ref={containerRef} />;
}
