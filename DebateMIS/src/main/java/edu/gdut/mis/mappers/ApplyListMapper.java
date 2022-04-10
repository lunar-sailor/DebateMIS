package edu.gdut.mis.mappers;

import edu.gdut.mis.entity.ApplyList;

public interface ApplyListMapper {

    /**
     * 通过辩论队ID查询 辩手信息
     * 应用场景，向辩论队管理员展示申请身份认证的辩手信息；
     * 如果一个辩手只能申请加入一个辩论队，应该以debateId为主键
     * 如果一个辩手可以加入多个队伍，应该以debateId和debateTeamId为联合主键
     *
     * 但是只提供一个getByTeamId方法，因为只向辩论队管理员展示申请加入本队的人员信息
     */
    ApplyList getDebaterByTeamId();
}
