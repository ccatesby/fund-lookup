import React from 'react';
import { useQuery } from 'graphql-hooks'
import { RunForceGraph } from './RunForceGraph';

export function Dashboard() {
  const GRAPH_QUERY = `query($nodeId: Int) {
      graphById(id:$nodeId) {
          nodes{
            id
            name
            type
          }
        links{
          type
          source
          target
        }
      }
    }
      `
  const nodeId = 1;
  const { refetch } = useQuery(GRAPH_QUERY, {
    variables: { nodeId }
  });

  return <RunForceGraph refetch={refetch} />;
}
