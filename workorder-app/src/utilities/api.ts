import { axiosConfig } from './axiosConfig';
import { IWorkOrder } from '../model/IWorkOrder';

export const getWOList = () => {
    return axiosConfig.get("workorder/all");
}

export const publishWorkOrder = (body: IWorkOrder) => {
    return axiosConfig.post("workorder/newworkorder", body);
}