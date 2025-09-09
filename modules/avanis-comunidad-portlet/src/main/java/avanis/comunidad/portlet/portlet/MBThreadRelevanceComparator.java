package avanis.comunidad.portlet.portlet;

import com.liferay.message.boards.model.MBMessage;
import com.liferay.message.boards.model.MBThread;
import com.liferay.message.boards.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.ratings.kernel.exception.NoSuchStatsException;
import com.liferay.ratings.kernel.model.RatingsStats;
import com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil;

import java.util.List;

public class MBThreadRelevanceComparator extends OrderByComparator<MBThread> {

    private static final Log _log = LogFactoryUtil.getLog(MBThreadRelevanceComparator.class);

    public static final String ORDER_BY_ASC = "MBMessage.relevance ASC";
    public static final String ORDER_BY_DESC = "MBMessage.relevance DESC";

    private final boolean _ascending;

    public MBThreadRelevanceComparator() {
        this(false);
    }

    public MBThreadRelevanceComparator(boolean ascending) {
        _ascending = ascending;
    }

    @Override
    public int compare(MBThread thread1, MBThread thread2) {
        double relevance1 = getRelevance(thread1);
        double relevance2 = getRelevance(thread2);

        int value = Double.compare(relevance1, relevance2);

        if (isAscending()) {
            return value;
        } else {
            return -value;
        }
    }

    private double getRelevance(MBThread thread) {
        try {
            RatingsStats ratingsStats = RatingsStatsLocalServiceUtil.getStats(MBMessage.class.getName(), thread.getRootMessageId());
            //int commentCount = MBMessageLocalServiceUtil.getChildMessagesCount(thread.getRootMessageId(), WorkflowConstants.STATUS_APPROVED);
            List<MBMessage> mbMessageList = MBMessageLocalServiceUtil.getChildMessages(thread.getRootMessageId(), WorkflowConstants.STATUS_APPROVED);
            int commentStatsCount = 0;
            int commentCount = mbMessageList.size();
            for (MBMessage mbMessage : mbMessageList) {
                commentStatsCount += RatingsStatsLocalServiceUtil.getStats(MBMessage.class.getName(), mbMessage.getMessageId()).getTotalEntries();
                List<MBMessage> mbReplyMessageList = MBMessageLocalServiceUtil.getChildMessages(mbMessage.getMessageId(), WorkflowConstants.STATUS_APPROVED);
                commentCount += mbReplyMessageList.size();
                for (MBMessage  mbReplyMessage : mbReplyMessageList) {
                    commentStatsCount += RatingsStatsLocalServiceUtil.getStats(MBMessage.class.getName(), mbReplyMessage.getMessageId()).getTotalEntries();
                }
            }

            return ratingsStats.getTotalScore() + commentStatsCount + commentCount;
        } catch (NoSuchStatsException e) {
            _log.debug("No existen estadísticas de calificación para el mensaje " + thread.getRootMessageId());
            return 0.0;
        } catch (PortalException e) {
            _log.error("Error al obtener las estadísticas de calificación para el mensaje " + thread.getRootMessageId(), e);
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
