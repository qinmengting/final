package com.qin.common.convert;

import com.qin.common.DTO.ArtMemberDTO;
import com.qin.common.VO.ArtMemberVO;
import com.qin.domain.ArtMember;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses=DateMapper.class)
public interface ArtMemberConvertMapper {

    ArtMemberConvertMapper INSTANCES = Mappers.getMapper(ArtMemberConvertMapper.class);

    ArtMemberVO memberToVO(ArtMember artMember);

    List<ArtMemberVO> membersToVOs(List<ArtMember> artMembers);

    ArtMember DTOtoMember(ArtMemberDTO artMemberDTO);

    ArtMemberDTO memberToDTO(ArtMember artMember);

    ArtMember VOToMember(ArtMemberVO artMemberVO);

}
