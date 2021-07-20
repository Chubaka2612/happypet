export class AnimalModel {
  public id!: number;
  public name!: string;
  public behavior?: string;
  public birthday?: string;
  public breedId?: number;
  public breed?: string;
  public cityId?: number;
  public city?: string;
  public colorId?: number;
  public color?: string ;
  public healthId?: number;
  public health?: string;
  public history?: string;
  public ownerId?:number;
  public curatorId?: number;
  public curatorFirstName?: string;
  public curatorPhoneNumber?:string;
  public hasPassport?: boolean;
  public vaccinated?: boolean;
  public sterilized?: boolean;
  public typeId?: number;
  public type?: string;
  public genderId? : number;
  public gender? : string;
  public age? : string;
  public organizationId?: number;
  public organizationName?: string;
  public booked?: boolean;
  public avatarUrl?: string;
}
