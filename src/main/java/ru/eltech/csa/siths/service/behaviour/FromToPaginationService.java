package ru.eltech.csa.siths.service.behaviour;

import ru.eltech.csa.siths.form.entity.Paginator;

public interface FromToPaginationService {
 
    Paginator paginate(long resultsTotal, byte resultsPerPage, long fromResult);
    
}