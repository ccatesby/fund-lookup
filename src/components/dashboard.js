import { ForceGraph } from "./forceGraph";
import { useQuery } from 'graphql-hooks'

export function Dashboard() {
    const GRAPH_QUERY = `query {
      graphByName(name:"1832") {
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
    const {data} = useQuery(GRAPH_QUERY, {
      variables: { language: 'english' },
    });

  return (
    <>
        ({ data && <ForceGraph linksData={data.graphByName.links} nodesData={data.graphByName.nodes} /> })
    </>
  );
}

