package com.nlmk.mes.rolling.config;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.CustomQuerydslCustomPredicateExecutorImpl;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryComposition.RepositoryFragments;
import org.springframework.data.repository.core.support.RepositoryFragment;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import static org.springframework.data.querydsl.QuerydslUtils.QUERY_DSL_PRESENT;

public class CustomJpaRepositoryFactory extends JpaRepositoryFactory {

    /**
     * Creates a new {@link JpaRepositoryFactory}.
     *
     * @param entityManager must not be {@literal null}
     */
    public CustomJpaRepositoryFactory(EntityManager entityManager, Class<?> revisionEntityClass) {
        super(entityManager);
    }

    @Override
    protected RepositoryFragments getRepositoryFragments(RepositoryMetadata metadata, EntityManager entityManager,
                                                         EntityPathResolver resolver,
                                                         CrudMethodMetadata crudMethodMetadata) {
        boolean isQueryDslRepository = QUERY_DSL_PRESENT &&
                QuerydslPredicateExecutor.class.isAssignableFrom(metadata.getRepositoryInterface());

        List<RepositoryFragment<?>> fragments = new ArrayList<>();

        if (isQueryDslRepository) {

            if (metadata.isReactiveRepository()) {
                throw new InvalidDataAccessApiUsageException(
                        "Cannot combine Querydsl and reactive repository support in a single interface");
            }

            fragments.add(RepositoryFragment.implemented(
                    new CustomQuerydslCustomPredicateExecutorImpl<>(getEntityInformation(metadata.getDomainType()),
                            entityManager,
                            resolver,
                            crudMethodMetadata)));
        }

        return RepositoryFragments.from(fragments);
    }
}
