package ru.eltech.csa.siths.service.implementation;

import ru.eltech.csa.siths.form.entity.Paginator;
import ru.eltech.csa.siths.service.behaviour.FromToPaginationService;
import ru.eltech.csa.siths.service.base.AbstractPaginationService;

import org.springframework.stereotype.Service;

@Service
public class FromToPaginationServiceImpl extends AbstractPaginationService implements FromToPaginationService {

    public FromToPaginationServiceImpl(){
        super();
    };

    public Paginator paginate(long resultsTotal, byte resultsPerPage, long fromResult) {
    	long currentPageNumber = fromResult / resultsPerPage + 1;
    	long pagesTotal = (long)Math.ceil( (double)resultsTotal /  (double)resultsPerPage );

    	if (pagesTotal <= pagesToDisplay) {
    		return new Paginator( (long)1, pagesTotal, currentPageNumber, Paginator.Type.PAGES_TOTAL_IS_LESSER_THAN_PAGES_TO_DISPLAY);
    	} else {
    		byte pageLeftRange = (byte)( ( pagesToDisplay % 2 == 1 )   
                                         ? ( pagesToDisplay / 2 - 1 )  
                                         : ( pagesToDisplay / 2 ) );
    		byte pageRightRange= (byte)( ( pagesToDisplay % 2 == 1 ) 
                                         ? pageLeftRange 
                                         : ( pageLeftRange - 1 ) );
    		boolean inRightBorder = ( currentPageNumber > ( pagesTotal - pageRightRange ) );
    		boolean inLeftBorder = ( currentPageNumber <= pageLeftRange );

            if ( inLeftBorder ) {
                return new Paginator(1, pagesToDisplay, currentPageNumber, Paginator.Type.CURRENT_PAGE_IS_IN_LEFT_BORDER_RANGE);
            } else if ( inRightBorder ) {
                long fromPageNumber = currentPageNumber - pageLeftRange;
                return new Paginator(fromPageNumber, pagesTotal, currentPageNumber, Paginator.Type.CURRENT_PAGE_IS_IN_RIGHT_BORDER_RANGE);
            } else {
                long fromPageNumber = currentPageNumber - pageLeftRange;
                long toPageNumber = currentPageNumber + pageRightRange;
                return new Paginator(fromPageNumber, toPageNumber, currentPageNumber, Paginator.Type.CURRENT_PAGE_IS_NOT_IN_BORDER_RANGE);
            }
    	}
    };

}