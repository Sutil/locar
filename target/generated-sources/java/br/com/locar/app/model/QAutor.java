package br.com.locar.app.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QAutor is a Querydsl query type for Autor
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAutor extends EntityPathBase<Autor> {

    private static final long serialVersionUID = -586970135;

    public static final QAutor autor = new QAutor("autor");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nome = createString("nome");

    public final StringPath sobrenome = createString("sobrenome");

    public QAutor(String variable) {
        super(Autor.class, forVariable(variable));
    }

    public QAutor(Path<? extends Autor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAutor(PathMetadata<?> metadata) {
        super(Autor.class, metadata);
    }

}

