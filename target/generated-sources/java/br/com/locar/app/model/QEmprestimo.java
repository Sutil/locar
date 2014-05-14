package br.com.locar.app.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QEmprestimo is a Querydsl query type for Emprestimo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QEmprestimo extends EntityPathBase<Emprestimo> {

    private static final long serialVersionUID = -1432311255;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QEmprestimo emprestimo = new QEmprestimo("emprestimo");

    public final DatePath<org.joda.time.LocalDate> devolucao = createDate("devolucao", org.joda.time.LocalDate.class);

    public final QExemplar exemplar;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<org.joda.time.LocalDate> previsaoDeDevolucao = createDate("previsaoDeDevolucao", org.joda.time.LocalDate.class);

    public final DatePath<org.joda.time.LocalDate> retirada = createDate("retirada", org.joda.time.LocalDate.class);

    public final br.com.locar.app.login.seguranca.QUsuario usuario;

    public QEmprestimo(String variable) {
        this(Emprestimo.class, forVariable(variable), INITS);
    }

    public QEmprestimo(Path<? extends Emprestimo> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEmprestimo(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEmprestimo(PathMetadata<?> metadata, PathInits inits) {
        this(Emprestimo.class, metadata, inits);
    }

    public QEmprestimo(Class<? extends Emprestimo> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.exemplar = inits.isInitialized("exemplar") ? new QExemplar(forProperty("exemplar"), inits.get("exemplar")) : null;
        this.usuario = inits.isInitialized("usuario") ? new br.com.locar.app.login.seguranca.QUsuario(forProperty("usuario"), inits.get("usuario")) : null;
    }

}

