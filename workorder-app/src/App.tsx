import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Route, Switch } from 'react-router-dom';
import { LandingComponent } from './components/Landing/LandingComponent';
import { WorkOrderComponent } from './components/WorkOrderTable/WorkOrderComponent';
import { history } from './history/history';
import { Router } from 'react-router';
import SubmitWO from './components/AddWO/SubmitWO';

const App: React.FC = () => {
  return (
    <div>
      <Router history={history}>
        <div>
          <Switch>
            <Route path='/workordertable' component={WorkOrderComponent}/>
            <Route path='/addworkorder' component={SubmitWO}/>
            <Route path='/' component={LandingComponent}/>
          </Switch>
        </div>
      </Router>
    </div>
  )
}

export default App;
