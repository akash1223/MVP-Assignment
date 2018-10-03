package assignment.infosys.com.infosysassignment;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import assignment.infosys.com.infosysassignment.apimodel.Facts;
import assignment.infosys.com.infosysassignment.dropbox.DropBoxContractMVP;
import assignment.infosys.com.infosysassignment.dropbox.DropBoxPresenter;
import assignment.infosys.com.infosysassignment.dropbox.DropBoxRepository;

import static org.mockito.Mockito.*;

public class DropBoxPresenterTest {

    DropBoxRepository mockDropBoxRepository;
    DropBoxContractMVP.View mockView;
    DropBoxPresenter presenter;
    List<Facts.Data> mData;

    @Before
    public void setup() {

        mockDropBoxRepository = mock(DropBoxRepository.class);

        mData=getMockdata();

        mockView = mock(DropBoxContractMVP.View.class);

        presenter = new DropBoxPresenter(mockDropBoxRepository);

        presenter.setView(mockView);

    }
    List<Facts.Data> getMockdata()
    {
        List<Facts.Data> mData=new ArrayList<>() ;
        mData.add(new Facts.Data("Beavers","Hockey Night in Canada","http://fyimusic.ca/wp-content/uploads/2008/06/hockey-night-in-canada.thumbnail.jpg"));
        mData.add(new Facts.Data("Public Shame","Sadly it's true.","http://static.guim.co.uk/sys-images/Music/Pix/site_furniture/2007/04/19/avril_lavigne.jpg"));
        mData.add(new Facts.Data("Geography","It's really big.",null));
        mData.add(new Facts.Data(null,null,null));
        return mData;
    }
    @Test
    public void  valiDate() {
        presenter.filterData(getMockdata());
        verify(mockView,never()).ErrorInDataLoad();

    }


}
