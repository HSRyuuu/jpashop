package jpabook.jpashop;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

   @Test
   @Transactional
   @Commit
   public void testMember() throws Exception{
       //given
       Member member = new Member();
       member.setUsername("memberA");

       //when
       Long savedId = memberRepository.save(member);
       log.info("savedMemberId = {}", savedId);
       Member findMember = memberRepository.find(savedId);
       log.info("findMember = {}", findMember );


       //then
       Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
       Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
       Assertions.assertThat(findMember).isEqualTo(member);
   }

}