import React from 'react';
import { IWorkOrder } from '../../model/IWorkOrder';
// import { Card, CardBody, CardTitle, CardSubtitle, CardText } from 'reactstrap';

export interface IWR {
    wo: IWorkOrder
}

export const WorkOrderDisplay:React.FC<IWR> = (props:IWR) => {

        return (
            // <div>
            //     <Card>
            //         <CardBody>
            //             <CardTitle>WORK ORDER</CardTitle>
            //             <CardSubtitle key={props.wo.createdDateTime}>{props.wo.createdDateTime}</CardSubtitle>
            //             <CardText key={props.wo.id}>{props.wo.id}</CardText>
            //             <CardText key={props.wo.description}>{props.wo.description}</CardText>
            //             <CardText>{props.wo.creatorId}</CardText>
            //             <CardText key={props.wo.contactEmail}>{props.wo.contactEmail}</CardText>
            //             <CardText key={props.wo.category}>{props.wo.category}</CardText>
            //             <CardText key={props.wo.status}>{props.wo.status}</CardText>
            //         </CardBody>
            //     </Card>
            // </div>

            <>
                <tr key={props.wo.id}>
                    <td key={props.wo.createdDateTime}>{props.wo.createdDateTime}</td>
                    <td key={props.wo.id}>{props.wo.id}</td>
                    <td key={props.wo.description}>{props.wo.description}</td>
                    <td>{props.wo.creatorId}</td>
                    <td key={props.wo.contactEmail}>{props.wo.contactEmail}</td>
                    <td key={props.wo.category}>{props.wo.category}</td>
                    <td key={props.wo.status}>{props.wo.status}</td>
                </tr>
            </>
        )
}