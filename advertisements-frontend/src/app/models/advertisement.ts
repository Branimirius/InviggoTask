export class Advertisement {

    id: number;
    name: string;
    description: string;
    photoUrl: string;
    price: number;
    category: string;
    userId: number;
    city: string;
    dateCreated: Date;

    constructor(){
        this.id = 0;
        this.name = "";
        this.description = "";
        this.photoUrl = "";
        this.price = 0;
        this.category = "";
        this.userId = 0;
        this.city = "";
        this.dateCreated = new Date();
       
    }
}