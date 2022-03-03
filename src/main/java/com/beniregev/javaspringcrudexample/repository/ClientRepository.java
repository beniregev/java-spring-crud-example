package com.beniregev.javaspringcrudexample.repository;

import com.beniregev.javaspringcrudexample.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <div>
 *     <p></p>
 * </div>
 * @author binyamin.regev
 * @see JpaRepository
 * @see Optional
 * @see Transactional
 * @see Modifying
 * @see Query
 * @see Param
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByUsername(String username);

    Optional<Client> findByUsernameAndEmail(String username, String email);

//    @Query("SELECT u FROM Client u WHERE u.isOnline = true")
//    List<Client> findAllOnlineClients();
//
//    @Transactional
//    @Modifying
//    @Query("UPDATE Client c set c.isOnline = :online,c.lastUpdated=:now WHERE c.id = :id")
//    void updateIsOnlineById(@Param("id") Integer id, @Param("online") Boolean isOnline, @Param("now") Date now);
//
//    @Transactional
//    @Modifying
//    @Query("UPDATE Client c set c.isOnline = true, c.loginCount = c.loginCount + 1,c.loginTime = :now,c.lastUpdated=:now,c.ip=:ip WHERE c.id = :id")
//    void loginClientById(@Param("id") Integer id, @Param("now") Date now,@Param("ip") String clientIP);

}
