import React, { SyntheticEvent } from 'react';
import { publishWorkOrder, publishRoom } from '../../utilities/api';
import { history } from '../../history/history';
import { Input, Form } from 'reactstrap';
import { Link } from 'react-router-dom';

interface INewRoomState {
    roomNumber: string,
    maxOccupancy: number,
    isActive: boolean,
    batchId: number,
}

export class SubmitRoom extends React.Component<INewRoomState, any> {
    constructor(props:any) {
        super(props)
        this.state = {
            roomNumber:'',
            maxOccupancy:'',
            isActive:'',
            batchId:''
        };
    }

    updateRoomNumber = (event:any) => {
        this.setState({
            ...this.state,
            roomNumber: event.target.value
        })
    }

    updateMaxOccupancy = (event:any) => {
        this.setState({
            ...this.state,
            maxOccupancy: event.target.value
        })
    }

    updateIsActive = (event:any) => {
        this.setState({
            ...this.state,
            isActive: event.target.value
        })
    }

    updateBatchId = (event:any) => {
        this.setState({
            ...this.state,
            batchId: event.target.value
        })
    } 

    submitRoom = async (event:SyntheticEvent) => {
        event.preventDefault();
        publishRoom({
            id: 0,
            roomNumber: this.state.roomNumber,
            maxOccupancy: this.state.maxOccupancy,
            isActive: this.state.isActive,
            batchId: this.state.batchId

        });
        history.push('/roomtable')
    }

    render() {
        return (
            <div>
                <Form onSubmit={this.submitRoom}>

                    <Input 
                        required
                        type="text"
                        value={this.state.roomNumber}
                        onChange={this.updateRoomNumber} />
                    <Input 
                        required
                        type="text"
                        value={this.state.maxOccupancy}
                        onChange={this.updateMaxOccupancy} />
                    <Input 
                        required
                        type="select"
                        value={this.state.isActive}
                        onChange={this.updateIsActive}>
                            <option>Active Status: </option>
                            <option value="true">True</option>
                            <option value="false">False</option>
                    </Input>
                    <Input
                        required
                        type="number"
                        value={this.state.batchId}
                        onChange={this.updateBatchId}/>
                    
                    <Input type="submit" value="Submit"/>

                </Form>
                <br/>
                <Link to='/'>Landing</Link>
            </div>
        )
    }

}
export default SubmitRoom;