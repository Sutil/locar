package br.com.locar.app.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QMulta is a Querydsl query type for Multa
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMulta extends EntityPathBase<Multa> {

    private static final long serialVersionUID = -575895433;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QMulta multa = new QMulta("multa");

    public final QEmprestimo emprestimo;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath pago = createBoolean("pago");

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QMulta(String variable) {
        this(Multa.class, forVariable(variable), INITS);
    }

    public QMulta(Path<? extends Multa> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMulta(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMulta(PathMetadata<?> metadata, PathInits inits) {
        this(Multa.class, metadata, inits);
    }

    public QMulta(Class<? extends Multa> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.emprestimo = inits.isInitialized("emprestimo") ? new QEmprestimo(forProperty("emprestimo"), inits.get("emprestimo")) : null;
    }

}

