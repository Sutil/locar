package br.com.locar.app.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QReserva is a Querydsl query type for Reserva
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QReserva extends EntityPathBase<Reserva> {

    private static final long serialVersionUID = 305792638;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QReserva reserva1 = new QReserva("reserva1");

    public final DatePath<org.joda.time.LocalDate> disponibilidade = createDate("disponibilidade", org.joda.time.LocalDate.class);

    public final DatePath<org.joda.time.LocalDate> expiracao = createDate("expiracao", org.joda.time.LocalDate.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QObra obra;

    public final DatePath<org.joda.time.LocalDate> reserva = createDate("reserva", org.joda.time.LocalDate.class);

    public final br.com.locar.app.login.seguranca.QUsuario usuario;

    public QReserva(String variable) {
        this(Reserva.class, forVariable(variable), INITS);
    }

    public QReserva(Path<? extends Reserva> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QReserva(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QReserva(PathMetadata<?> metadata, PathInits inits) {
        this(Reserva.class, metadata, inits);
    }

    public QReserva(Class<? extends Reserva> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.obra = inits.isInitialized("obra") ? new QObra(forProperty("obra")) : null;
        this.usuario = inits.isInitialized("usuario") ? new br.com.locar.app.login.seguranca.QUsuario(forProperty("usuario"), inits.get("usuario")) : null;
    }

}

