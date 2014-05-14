package br.com.locar.app.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QExemplar is a Querydsl query type for Exemplar
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QExemplar extends EntityPathBase<Exemplar> {

    private static final long serialVersionUID = -1002848958;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QExemplar exemplar = new QExemplar("exemplar");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> identificador = createNumber("identificador", Integer.class);

    public final QObra obra;

    public final EnumPath<br.com.locar.app.bean.StatusExemplar> status = createEnum("status", br.com.locar.app.bean.StatusExemplar.class);

    public QExemplar(String variable) {
        this(Exemplar.class, forVariable(variable), INITS);
    }

    public QExemplar(Path<? extends Exemplar> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QExemplar(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QExemplar(PathMetadata<?> metadata, PathInits inits) {
        this(Exemplar.class, metadata, inits);
    }

    public QExemplar(Class<? extends Exemplar> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.obra = inits.isInitialized("obra") ? new QObra(forProperty("obra")) : null;
    }

}

