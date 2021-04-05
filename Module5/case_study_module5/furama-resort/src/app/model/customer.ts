import {CustomerType} from './customerType';

export interface Customer {
  id: number;
  code: string;
  name: string;
  customerType: CustomerType;
  dateOfBirth: string;
  cardId: string;
  phone: string;
  email: string;
  address: string;
}
