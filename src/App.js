import { ForceGraph } from "./components/forceGraph";
import './App.css';
import useAxios from 'axios-hooks';
import styled from 'styled-components';

const Container = styled.div`
  height: 100%;
  width: 100%;
`;

function App() {
  const [{ data }] = useAxios(  {
    url: 'http://localhost:8080/graph',
    method: 'GET'
  });

  return (
    <Container>
       ({ data && <ForceGraph linksData={data.links} nodesData={data.nodes} /> })
    </Container>
  );
}

export default App;
