import React, { useState, useEffect } from 'react';
import { getWOList } from '../../utilities/api';
import { IWorkOrder } from '../../model/IWorkOrder';
import { Table } from 'reactstrap';
import { WorkOrderDisplay } from './WorkOrderDisplay';
import { Link } from 'react-router-dom';

export const WorkOrderComponent:React.FC<any> = (props:any) => {
    const [workOrderList, setWorkOrderList] = useState([]);
    useEffect(() => {
        getWOList().then(r=>setWorkOrderList(r.data));
    }, [workOrderList.length]);

    return (
        <div>
            {/* <Card>
                {workOrderList.map((r:IWorkOrder) => <WorkOrderDisplay wo={r}/>)}
            </Card> */}

            <Table striped>
                <thead>
                    <tr>
                        <th>Submitted</th>
                        <th>Work Order ID</th>
                        <th>Description</th>
                        <th>Creator ID</th>
                        <th>Contact Email</th>
                        <th>Category</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {workOrderList.map((r:IWorkOrder) => <WorkOrderDisplay wo={r}/>)}
                </tbody>
            </Table>

            <Link to='/'>Landing</Link>
        </div>
    )
}