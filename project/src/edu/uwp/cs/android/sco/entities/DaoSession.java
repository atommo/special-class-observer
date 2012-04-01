package edu.uwp.cs.android.sco.entities;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.IdentityScopeType;

import edu.uwp.cs.android.sco.entities.Student;
import edu.uwp.cs.android.sco.entities.Disability;
import edu.uwp.cs.android.sco.entities.Course;

import edu.uwp.cs.android.sco.entities.StudentDao;
import edu.uwp.cs.android.sco.entities.DisabilityDao;
import edu.uwp.cs.android.sco.entities.CourseDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentDaoConfig;
    private final DaoConfig disabilityDaoConfig;
    private final DaoConfig courseDaoConfig;

    private final StudentDao studentDao;
    private final DisabilityDao disabilityDao;
    private final CourseDao courseDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        disabilityDaoConfig = daoConfigMap.get(DisabilityDao.class).clone();
        disabilityDaoConfig.initIdentityScope(type);

        courseDaoConfig = daoConfigMap.get(CourseDao.class).clone();
        courseDaoConfig.initIdentityScope(type);

        studentDao = new StudentDao(studentDaoConfig, this);
        disabilityDao = new DisabilityDao(disabilityDaoConfig, this);
        courseDao = new CourseDao(courseDaoConfig, this);

        registerDao(Student.class, studentDao);
        registerDao(Disability.class, disabilityDao);
        registerDao(Course.class, courseDao);
    }
    
    public void clear() {
        studentDaoConfig.getIdentityScope().clear();
        disabilityDaoConfig.getIdentityScope().clear();
        courseDaoConfig.getIdentityScope().clear();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public DisabilityDao getDisabilityDao() {
        return disabilityDao;
    }

    public CourseDao getCourseDao() {
        return courseDao;
    }

}
