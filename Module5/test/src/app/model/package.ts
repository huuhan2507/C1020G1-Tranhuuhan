import {Product} from './product';

export interface Package {
  id: number;
  code: string;
  product: Product;
  amount: number;
  dateStart: string;
  dateStartPro: string;
  dateEndPro: string;
}
