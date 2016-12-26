package org.egov.bootcamp.service;

import org.egov.bootcamp.dao.EntityDao;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class EntityServiceTest {

    @Mock
    private EntityDao entityDao;

    @InjectMocks
    private EntityService entityService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(entityDao.get(0)).thenReturn(null);
    }

}