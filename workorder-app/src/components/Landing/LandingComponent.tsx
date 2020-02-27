import React from 'react';
import { Link } from 'react-router-dom';

export class LandingComponent extends React.Component {
    render() {
        return (
            <div>
                <h3>Landing Page</h3>
                <br/>
                <Link to='/workordertable'>Work Order Table</Link>
                <br/>
                <br/>
                <br/>
                <Link to='/addworkorder'>Add New Work Order</Link>
            </div>
        )
    }
}