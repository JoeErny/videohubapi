package org.cnam.videohub.domain.service;


import org.cnam.videohub.domain.entity.User;
import org.cnam.videohub.domain.service.FidelityPointsService;
import org.cnam.videohub.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SponsorshipService {

    @Autowired
    private UserService userService;

    @Autowired
    private FidelityPointsService fidelityPointsService;


    public void userSponsorsAnother(Long idSponsoringUser, Long idSponsorizedUser)
    {
        User sponsoringUser = userService.getById(idSponsoringUser);
        User sponsorizedUser = userService.getById(idSponsorizedUser);

        if(sponsoringUser.id != null && sponsorizedUser.id != null)
        {
            fidelityPointsService.addFidelityPointsToUser(FidelityPointsService.BONUSES.SPONSORED_BONUS.getValue(),sponsorizedUser.id);
            fidelityPointsService.addFidelityPointsToUser(FidelityPointsService.BONUSES.PATRON_BONUS.getValue(),sponsoringUser.id);
        }

    }

}
