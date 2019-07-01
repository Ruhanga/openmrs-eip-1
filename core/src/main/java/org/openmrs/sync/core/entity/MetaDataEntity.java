package org.openmrs.sync.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openmrs.sync.core.entity.light.UserLight;
import org.openmrs.sync.core.utils.DateUtils;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class MetaDataEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "creator")
    protected UserLight creator;

    @NotNull
    @Column(name = "date_created")
    protected LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "changed_by")
    protected UserLight changedBy;

    @Column(name = "date_changed")
    protected LocalDateTime dateChanged;

    @ManyToOne
    @JoinColumn(name = "retired_by")
    private UserLight retiredBy;

    @Column(name = "retired_date")
    private LocalDateTime retiredDate;

    @Column(name = "retire_reason")
    private String retireReason;

    @NotNull
    @Column(name = "retired")
    private boolean retired;

    @Override
    public boolean wasModifiedAfter(final BaseEntity entity) {
        MetaDataEntity metaData = (MetaDataEntity) entity;
        List<LocalDateTime> datesToCheck = Arrays.asList(
                metaData.getDateCreated(),
                metaData.getDateChanged(),
                metaData.getRetiredDate());
        boolean dateCreatedAfter = DateUtils.isDateAfterAtLeastOneInList(getDateCreated(), datesToCheck);
        boolean dateChangedAfter = DateUtils.isDateAfterAtLeastOneInList(getDateChanged(), datesToCheck);
        boolean dateVoidedAfter = DateUtils.isDateAfterAtLeastOneInList(getRetiredDate(), datesToCheck);
        return dateCreatedAfter || dateChangedAfter || dateVoidedAfter;
    }
}