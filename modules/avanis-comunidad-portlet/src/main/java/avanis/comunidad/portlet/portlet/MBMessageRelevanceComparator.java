package avanis.comunidad.portlet.portlet;

import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.ratings.kernel.exception.NoSuchStatsException;
import com.liferay.ratings.kernel.model.RatingsStats;
import com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil;

public class MBMessageRelevanceComparator extends OrderByComparator<MBMessage> {

    private static final Log _log = LogFactoryUtil.getLog(MBMessageRelevanceComparator.class);

    public static final String ORDER_BY_ASC = "MBMessage.relevance ASC";
    public static final String ORDER_BY_DESC = "MBMessage.relevance DESC";

    private final boolean _ascending;

    public MBMessageRelevanceComparator() {
        this(false);
    }

    public MBMessageRelevanceComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(MBMessage message1, MBMessage message2) {
        double relevance1 = getRelevance(message1);
        double relevance2 = getRelevance(message2);

        int value = Double.compare(relevance1, relevance2);

        if (_ascending) {
            return value;
        } else {
            return -value;
        }
    }

    private double getRelevance(MBMessage message) {
        try {
            RatingsStats ratingsStats = RatingsStatsLocalServiceUtil.getStats(
                    MBMessage.class.getName(), message.getMessageId());
            int commentCount = MBMessageLocalServiceUtil.getChildMessagesCount(message.getMessageId(), WorkflowConstants.STATUS_APPROVED);

            return ratingsStats.getTotalScore() + commentCount;
        } catch (NoSuchStatsException e) {
            _log.warn("No existen estadísticas de calificación para el mensaje " + message.getMessageId());
            return 0.0;
        } catch (PortalException e) {
            _log.error("Error al obtener las estadísticas de calificación para el mensaje " + message.getMessageId(), e);
            return 0.0;
        }
    }

    @Override
    public String getOrderBy() {
        if (isAscending()) {
            return ORDER_BY_ASC;
        } else {
            return ORDER_BY_DESC;
        }
    }

    @Override
    public String[] getOrderByFields() {
        return new String[] { "relevance" };
    }

    @Override
    public boolean isAscending() {
        return _ascending;
    }
}
