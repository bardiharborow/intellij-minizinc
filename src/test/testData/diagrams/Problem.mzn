class SuperEntity (string: superAttribute);
class RelatedEntity (Entity: associationRelated;);
class Entity extends SuperEntity (
    string: attribute;
    RelatedEntity: related;
    var RelatedEntity: variableRelated;
    opt RelatedEntity: optionalRelated;
    var opt RelatedEntity: variableOptionalRelated;
    RelatedEntity: associationRelated;
);
constraint association(Entity.associationRelated, RelatedEntity.associationRelated);