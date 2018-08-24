enum TypeFolder {
	dossierJuridique,
	dossierAnnuel,
	janvier,
	fevrier,
	mars,	
	avril,	
	mai,	
	juin,	
	juillet,	
	aout,
	septembre,	
	octobre,	
	novembre,	
	decembre
}
export class Document {

    public id : number;
    public path : String;
    public dateDeCreation : String;
    public type : TypeFolder;
}
