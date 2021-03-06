package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import board.model.vo.Board;
import board.model.vo.BoardComment;
import common.SemiException;

public class BoardDao {
	private Properties prop = new Properties();

	public BoardDao() {
		
		String fileName = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//boardListServlet 에서 사용되는 페이지당 필요한 list불러오는 메서드
	public List<Board> selectBoardList(Connection conn, int start, int end) {
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setTitle(rset.getString("title"));
				b.setWriter(rset.getString("writer"));
				b.setContent(rset.getString("content"));
				b.setRegDate(rset.getDate("reg_date"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("자유게시판 목록을 불러오지 못했습니다.",e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public int selectBoardTotal(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardTotal");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("자유게시판 총 글수를 불러오지 못했습니다.",e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int insertBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("자유게시판 게시글 등록에 실패하였습니다.",e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//게시글 번호로 해당 게시글에 댓글이 몇개가 있는지 조회하는 메서드
	public int selectCommentCnt(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCommentCnt");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("댓글의 총 갯수를 불러오지 못했습니다.",e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
	//board객체 하나를 조회하는 메서드
	public Board selectBoardOne(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBoardOne");
		Board board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				board = new Board();
//				board = new Board(boardNo, title, writer, content, regDate, commentCnt)
				board.setBoardNo(boardNo);
				board.setTitle(rset.getString("title"));
				board.setWriter(rset.getString("writer"));
				board.setContent(rset.getString("content"));
				board.setRegDate(rset.getDate("reg_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("게시글 조회를 실패했습니다.",e);
		}
		return board;
	}

	//boardView next,prev를 위한 boardNumList가져오기
	public List<Integer> selectBoardNumList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Integer> list = new ArrayList<Integer>();
		String sql = prop.getProperty("selectBoardNumList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(rset.getInt("board_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("이전글 다음글 값을 가져오는데 실패했습니다.",e);
		}
		return list;
	}

	public int updateBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		System.out.println(sql);
		System.out.println(board);
		
		try {
			pstmt=conn.prepareStatement(sql);
			//제목, 내용, 보드번호
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("자유게시판 게시글 수정에 실패하였습니다.",e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("게시글 삭제에 실패하였습니다.",e);
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//게시물에 해당하는 commentList를 가져오는 메서드
	public List<BoardComment> selectCommentList(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<BoardComment> list = new ArrayList<BoardComment>();
		String sql = prop.getProperty("selectCommentList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BoardComment bc = new BoardComment();
				bc.setCommentNo(rset.getInt("comment_no"));
				bc.setCommentLevel(rset.getInt("comment_level"));
				bc.setWriter(rset.getString("writer"));
				bc.setContent(rset.getString("content"));
				bc.setBoardNo(rset.getInt("board_no"));
				bc.setCommentRef(rset.getInt("comment_ref"));
				bc.setRegDate(rset.getDate("reg_date"));
				list.add(bc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("댓글 목록을 가져오는데 실패했습니다.",e);
		}
		return list;
	}

	public int insertComment(Connection conn, BoardComment bc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bc.getCommentLevel());
			pstmt.setString(2, bc.getWriter());
			pstmt.setString(3, bc.getContent());
			pstmt.setInt(4, bc.getBoardNo());
			pstmt.setObject(5, bc.getCommentRef()==0 ? null : bc.getCommentRef());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("댓글작성에 실패하였습니다.",e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBoardComment(Connection conn, int boardCommentNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteBoardComment");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("댓글 삭제에 실패하였습니다.",e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<Board> selectAdminBoardList(Connection conn, int start, int end) {
		List<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdminBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setTitle(rset.getString("title"));
				b.setWriter(rset.getString("writer"));
				b.setContent(rset.getString("content"));
				b.setRegDate(rset.getDate("reg_date"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("공지사항 목록을 불러오지 못했습니다.",e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int selectAdminBoardTotal(Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdminBoardTotal");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result = rset.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("공지사항 총 글수를 불러오지 못했습니다.",e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int insertAdminBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAdminBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("공지사항 게시글 등록에 실패하였습니다.",e);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Board selectAdminBoardOne(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdminBoardOne");
		Board board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				board = new Board();
//				board = new Board(boardNo, title, writer, content, regDate, commentCnt)
				board.setBoardNo(boardNo);
				board.setTitle(rset.getString("title"));
				board.setWriter(rset.getString("writer"));
				board.setContent(rset.getString("content"));
				board.setRegDate(rset.getDate("reg_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("공지사항 조회를 실패했습니다.",e);
		}
		return board;
	}

	public List<Integer> selectAdminBoardNumList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Integer> list = new ArrayList<Integer>();
		String sql = prop.getProperty("selectAdminBoardNumList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(rset.getInt("board_no"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("이전글 다음글 값을 가져오는데 실패했습니다.",e);
		}
		return list;
	}

	public int updateAdminBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAdminBoard");
		System.out.println(sql);
		System.out.println(board);
		
		try {
			pstmt=conn.prepareStatement(sql);
			//제목, 내용, 보드번호
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("공지사항 게시글 수정에 실패하였습니다.",e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteAdminBoard(Connection conn, int boardNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteAdminBoard");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SemiException("공지사항 삭제에 실패하였습니다.",e);
		} finally {
			close(pstmt);
		}
		return result;
	}

}
