import React from 'react';
import { IRoom } from '../../model/IRoom';

export interface IRR {
    room: IRoom
}

export const RoomTableDisplay:React.FC<IRR> = (props:IRR) => {

    return (

        <>
            <tr key={props.room.id}>
                <td key={props.room.id}>{props.room.id}</td>
                <td key={props.room.currentStatus}>{props.room.currentStatus}</td>
                <td key={props.room.roomNumber}>{props.room.roomNumber}</td>
                <td>{props.room.isActive}</td>
                <td key={props.room.maxOccupancy}>{props.room.maxOccupancy}</td>
            </tr>
        </>

    )
}