import { HouseBookingComponent } from '../house-booking/house-booking.component';
import { House } from './House';

export class Booking {
    booking_record_id: Number;
    check_in_date: Date;
    check_out_date: Date;
    toatal_price: Number;
    house: House;
}
