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
    public anneeDeCreation : String;
	public type : TypeFolder;
	public name : string;
	constructor (path?:string , anneeDeCreation?:string , type?:TypeFolder)
	{
		this.anneeDeCreation=anneeDeCreation;
		this.path=path;
		this.type=type;
	}
}
