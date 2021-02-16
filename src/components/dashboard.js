import React from 'react';
import { useQuery } from 'graphql-hooks'
import { ForceGraph } from './forceGraph/ForceGraph';

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

  const { refetch } = useQuery(GRAPH_QUERY);

  return <ForceGraph refetch={refetch} />;
}
