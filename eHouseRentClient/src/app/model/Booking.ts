import { HouseBookingComponent } from '../house-booking/house-booking.component';
import { House } from './House';
import {user } from './user';

export class Booking {
    bookingRecordId: Number;
    checkInDate: Date;
    checkOutDate: Date;
    totalPrice: Number;
    house: House;
    user: user;
}
