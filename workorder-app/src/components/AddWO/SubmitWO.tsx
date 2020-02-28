import React, { SyntheticEvent } from 'react';
import { publishWorkOrder } from '../../utilities/api';
import { history } from '../../history/history';
import { Input, Form } from 'reactstrap';
import { Link } from 'react-router-dom';

interface INewWOState {
    category: string,
    description: string,
    contactEmail: string,
}

export class SubmitWO extends React.Component<INewWOState, any> {
    constructor(props:any) {
        super(props)
        this.state = {
            category:'',
            description:'',
            contactEmail:'',
        };
    }

    updateCategory = (event:any) => {
        this.setState({
            ...this.state,
            category: event.target.value
        })
    }

    updateDescription = (event:any) => {
        this.setState({
            ...this.state,
            description: event.target.value
        })
    }

    updateContactEmail = (event:any) => {
        this.setState({
            ...this.state,
            contactEmail: event.target.value
        })
    }

    submitWorkOrder = async (event:SyntheticEvent) => {
        event.preventDefault();
        publishWorkOrder({
            id: 0,
            createdDateTime: '',
            resolvedDateTime: null,
            category: this.state.category,
            status: 'PENDING',
            description: this.state.description,
            contactEmail: this.state.contactEmail,
            creatorId: 0,
            resolverId: null
        });
        history.push('/workordertable')
    }

    render() {
        return (
            <div>
                <Form onSubmit={this.submitWorkOrder}>

                    <Input
                        required
                        type="select"
                        name="inputcat"
                        // placeholder="Select Category"
                        value={this.state.category} 
                        onChange={this.updateCategory}>
                            <option>Select A Category</option>
                            <option>LIGHTING</option>
                            <option>AIR_CONDITIONING</option>
                            <option>DOORS</option>
                            <option>PROJECTOR</option>
                            <option>OTHER</option>
                    </Input>

                    <Input 
                        required
                        type="textarea"
                        name="inputdesc"
                        placeholder="Description"
                        value={this.state.description}
                        onChange={this.updateDescription} />
                        
                    <Input 
                        required
                        type="email"
                        name="inputemail"
                        placeholder="Email"
                        value={this.state.contactEmail}
                        onChange={this.updateContactEmail} />
                    
                    <Input type="submit" value="Submit"/>

                </Form>
                <br/>
                <Link to='/'>Landing</Link>
            </div>
        )
    }

}
export default SubmitWO;