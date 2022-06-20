package microstamp.step1.configuration;

import microstamp.step1.data.UserEntity;
import microstamp.step1.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userEntityRepository.getUserByUsername(s);

        if(user == null){
            throw new UsernameNotFoundException("Could not find user!");
        }

        return new MyUserDetails(user);
    }
}
