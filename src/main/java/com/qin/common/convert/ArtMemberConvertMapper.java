package com.qin.common.convert;

import com.qin.common.VO.ArtMemberVO;
import com.qin.domain.ArtMember;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ArtMemberConvertMapper {

    ArtMemberConvertMapper INSTANCES = Mappers.getMapper(ArtMemberConvertMapper.class);

    ArtMemberVO memberToVO(ArtMember artMember);

    List<ArtMemberVO> membersToVOs(List<ArtMember> artMembers);
}
