import React from 'react';
import { useQuery } from 'graphql-hooks'
import { ForceGraph } from '../components/forceGraph/ForceGraph';

const Dashboard = () => {
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
export { Dashboard };