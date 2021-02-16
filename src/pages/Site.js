// @flow
import React from 'react';
import { Router } from '@reach/router';
import { Layout } from './Layout';
import { ListFunds } from './ListFunds';
import { Dashboard } from './Dashboard';

const Site = () => {
  return (
    <Router>
      <Layout path="/">
        <ListFunds path="/list" />
        <Dashboard path="dashboard" />
      </Layout>
    </Router>
  );
};

export { Site };
