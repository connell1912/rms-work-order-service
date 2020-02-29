import { axiosConfig } from './axiosConfig';
import { IWorkOrder } from '../model/IWorkOrder';

export const getWOList = () => {
    return axiosConfig.get("work-order-service/workorder/all");
}

export const publishWorkOrder = (body: IWorkOrder) => {
    return axiosConfig.post("work-order-service/workorder/newworkorder", body);
}

export const getRooms = () => {
    return axiosConfig.get("campus-service/room/all");
}
