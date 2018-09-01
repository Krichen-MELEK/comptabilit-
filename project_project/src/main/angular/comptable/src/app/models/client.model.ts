export class Client {
    
    public id: number;
    constructor(public nom: String, public prenom: String, public email: String, 
        public telephone: String, public motDePasse: String, public nomSociete: String,
        public matricule: String, public telSociete: String, public numRegistreCommerce: String, public secteurActivite: String,
        public adresseSociete: String, public emailSociete: String, public validation: boolean){}
}
