import { ForceGraph } from "./forceGraph";
import { useQuery } from 'graphql-hooks'

export function Dashboard() {
    const GRAPH_QUERY = `query {
        fundByName(name:"1832") {
          name
          stocks{
            name 
          }
        }
      }`
      const {data} = useQuery(GRAPH_QUERY, {
        variables: { language: 'english' },
      });
      console.log(data);

  return (
    <>
        ({ data && <ForceGraph linksData={data.links} nodesData={data.nodes} /> })
    </>
  );
}

