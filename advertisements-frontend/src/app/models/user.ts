export class User {
    id: number;
    username: string;
    password: string;
    phone: string;
    dateJoined: Date;

    constructor(){
        this.id = 0;
        this.username = "";
        this.password = "";
        this.dateJoined = new Date();
        this.phone = "";
       
    }
}