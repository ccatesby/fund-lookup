import { ForceGraph } from "./forceGraph";
import { useQuery } from 'graphql-hooks'

export function Dashboard() {
    const GRAPH_QUERY = `query {
      graphById(id:1) {
          nodes{
            id
            name
          }
        links{
          type
          source
          target
        }
      }
    }
      `
  const {data} = useQuery(GRAPH_QUERY);
 
  return (
    <>
        ({ data && <ForceGraph linksData={data.graphById.links} nodesData={data.graphById.nodes} /> })
    </>
  );
}

