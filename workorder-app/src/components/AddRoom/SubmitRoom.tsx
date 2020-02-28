import React, { SyntheticEvent } from "react";

interface INewRoomState {
  roomNumber: string;
  maxOccupancy: number;
  isActive: boolean;
  batchId: number;
}

export class SubitRoom extends React.Component<INewRoomState, any> {
  constructor(props: any) {
    super(props);
    this.state = {
      roomNumber: "",
      maxOccupancy: "",
      isActive: "",
      batchId: ""
    };
  }





  
}

